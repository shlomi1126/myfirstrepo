$(document).ready(function(){
 $(" #clientlist").on('click', function(event) {	
$.ajax(
			{	
				cache: false,
				url:"clientController?action=clientlist",
				data:{xxx:"xxx"},
				success: function(result)
				{
					$("#homepageclienttable").html($(result).find("#clienttable"));
				},
				dataType: 'html'
			});
});
			  });

function findclienta(){
	$.ajax({
		cache:false,
		url: "clientController?action=find",
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
		
			$("#homepageclienttable2").html($(result).find("#getclientbyid"));
		},
		dataType: 'html'
		}
	);
}
	

function findclientb (x){
	$.ajax({
		cache:false,
		url: "clientController?action=find&id="+x,
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			$("#homepageclienttable").html($(result).find("#clienttable"));
			
		},
		dataType: 'html'
		}
	);
	
	
}

function addClienta (){
	$.ajax({
		cache:false,
		url: "clientController?action=add",
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			
			$("#formClient").html($(result).find("#formC"));
			
		},
		dataType: 'html'
		}
	);
}
function addClienta2 (){
	event.preventDefault();
	var $form = $('#formC'),
	clientid = $form.find('input[name="client_id"]').val(),
	clientFname = $form.find('input[name="f_name"]').val(),
	clientLname = $form.find('input[name="l_name"]').val(),
	clientmail = $form.find('input[name="client_mail"]').val(),
	clientphone = $form.find('input[name="client_phone"]').val(),
	a=$form.find('input[name = "action_type"]').val(),
	servlet=$form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:clientid,
			fn:clientFname,
			ln:clientLname,
			cm:clientmail,
			cp:clientphone,
			action_type:a
			
			 },
		datatype:'html',
		success:function(result)
		{
			alert(result);
			$("#homepageclienttable").html($(result).find("#clienttable")); 
			$('#formC').hide();
		}
	});
}
	

