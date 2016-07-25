var offenceArray;

$(document).ready(function(){
	$.ajax({
		url:"/offence",
		type: "get",
		error: function(){
			$("#messageSpan").html('Unable to fetch offence type');
		},
		success: function(data){
			for(var item in data){
				$("#offences").append('<option value="'+data[item].id+'">'+data[item].offenceName+'</option>')
			}
			offenceArray = data;
		}
	});
});

function calculate(){
	var studentName = $("#studentName").val();
	var offences = $("#offences").val();
	var timeType = $("input[type='radio'][name='time']:checked").val();
	var calculationType = $("input[type='radio'][name='calculation']:checked").val();
	var tempOffenceArray = [];
	for(var offence in offenceArray){
		if($.inArray(String(offenceArray[offence].id), offences) > -1){
			tempOffenceArray.push(offenceArray[offence]);
		}
	}
	
	var formData = new FormData();
	formData.append("studentName", studentName);
	formData.append("timeType", timeType);
	formData.append("calculationType", calculationType);
	formData.append("offences", offences);
	
	$.ajax({
		url:"/calculate",
		type: "post",
		data: formData,
		processData: false,
	    contentType: false,
		error: function(){
			$("#messageSpan").html('Error occurred while calculation');
		},
		success: function(data){
			var parsedJson = $.parseJSON(data);
			if(parsedJson.calculatedTime == -1){
				$("#messageSpan").html('Total detention hours are more than 8 hours!');
			}
			else{
				$("#messageSpan").html('Total time: '+parsedJson.calculatedTime+' minutes');
			}
		}
	});
}