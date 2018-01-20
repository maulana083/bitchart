var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/ticker-ws');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		sendName();
		stompClient.subscribe('/ws/greetings', function(greeting) {
			showGreeting(JSON.parse(greeting.body));
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendName() {
	stompClient.send("/app/hello", {}, '');
}

function showGreeting(message) {
	$("#greetings").html("<tr>" +
			"<th> Time</th>" +
			"<th>Name</th>" +
			"<th> Symbol</th>" +
			"<th>Price in USD</td>" +
			"<th>1 Hour % change</td>" +
			"<th>24 Hour % change</td>" +
			"</tr>");

	$.each(message, function(key, value) {
		
		var html="<tr>" +
		"<td>" + value.lastUpdatedTime + " </td>"+
		"<td>" + value.name + " </td>"+
		"<td>" + value.symbol + " </td>" +
		"<td>$" + value.priceUsd+"</td>";
		if(value.percentChange1H>=0){
			html+="<td id='green'>";
		}else{
			html+="<td id='red'>";
		}
		html+=(value.percentChange1H + " </td>"); 
		if(value.percentChange24H>=0){
			html+="<td id='green'>";
		}else{
			html+="<td id='red'>";
		}
		html+=value.percentChange24H + " </td>";
		html+="</tr>";
		
		
		$("#greetings").append(html);
	});
	
	$("#last-updated").html(new Date().toLocaleDateString()+" "+new Date().toLocaleTimeString());
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
});
