function findonebook() {
	var url =window.location.href;
	var id=url.split("?bid=")[1];
		$.ajax({
				url : "findOneBook",
				type : "post",	
				data : {
					"bid" : id
				},
				dataType : 'json',
				success : function(data) {
					// alert(data);
					var content = "<div class='panel panel-default'>"
								+ "<div class='panel-body'>"
								+ "<div id=image>"
								+ "<img src='"
								+ data.img
								+ "' class='img-responsive'>"
								+ "</div>"
								+ "<div id='tother'>"
								+ "<h3>&nbsp;&nbsp;&nbsp;&nbsp;书名："
								+ data.bname
								+ " &nbsp;</h3>"
								+ "<h3>&nbsp;&nbsp;&nbsp;&nbsp;评论数量："
								+ data.comcount
								+ "</h3>"
								+ "<h3>&nbsp;&nbsp;&nbsp;&nbsp;当前库存："
								+ data.bcount
								+ "本&nbsp;&nbsp;&nbsp;&nbsp;订阅价："
								+ data.price
								+ "元</h3>"
								+ "</div>"
								+ "</div>" + "</div>";
					
					$("#detailbook").html(content);
					
				},
			error:function () {
				alert("error");
			}
			});
}
findonebook();


function findcommets(){
	var bbid = parseInt($("#canshu").html());
//	alert("你好");
	$.ajax({
		url:"findCommets",
		type:"post",
		data : {
			"bid" : bbid
		},
		dataType:'json',
		success:function(data){
//			alert(data.bid);
			var content="";
			for(var i=0; i< data.length; i++){
				var po=data[i];
				content+="<tr>"				
					+"<td class='infor1'>"+po.luser+"</td>"
					+"<td class='infor2'>"+po.cdate+"</td>"
					+"<td class='infor3'>"+po.ccont+"</td>"					
										
					+"</tr>";
			}
				$("#comment").html(content);
			
		}
	});
}
findcommets();

function insertcomment(){
	var bbid = parseInt($("#canshu").html());
//	alert("你好");
	$.ajax({
		url:"insertComment",
		type:"post",
		data:{
			"ccont":$("#ccont").val(),
			"bid" : bbid
		},
		dataType:'json',
		success:function(data){
//			alert(data);
		 	if(data=="评论失败，请先登录"){
		 		alert(data);
			}else if(data=="请输入评价"){
				alert(data);
			}else{
				alert(data);
				window.location.reload();
			}
				
		}	
	});
}

