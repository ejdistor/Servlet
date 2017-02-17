<html>
<head>
	<script src="${pageContext.request.contextPath}/js/prototype.js"></script>
</head>
<body>
	<div id="mainContents">
<%@  page import="java.util.List, java.util.ArrayList, java.util.Map"

%> 

	<%
		List<Map<String, Object>> map = (List<Map<String, Object>>)request.getAttribute("object");
	out.print(map != null);
	if(map != null){
		for(Map<String, Object> m : map){
			out.print(m.get("index")+"<br>");
		}	
	}
	
	%>
	<h1>WELCOME</h1>
		<h1>Welcome to index!</h1>
		Name: <input type="text" id="txtName" value="edward"/><br>
		Age: <input type="text" id="txtAge" value="2"/><br>
		Address: <input type="text" id="txtAddress" value="qc"/><br>
		<p>Checkbox</p>
		1: <input type="checkbox" name="check" id="chk1" />
		2: <input type="checkbox" name="check" id="chk2" />
		3: <input type="checkbox" name="check" id="chk3" />
		<input type="button" id="btnSubmit" value="Submit" />
	</div>
</body>
<script type="text/JavaScript">
	function submit(){
		
		for(var i = 0; i<checked.length; i++){
			console.log(i+" "+checked[i]);
		}
		
		new Ajax.Request("${pageContext.request.contextPath}"+
				"/home", {
			method : "get",
			parameters : {
				action : "goToMain",
				name : $F("txtName"),
				age : $F("txtAge"),
				address : $F("txtAddress"),
				checked : checked
			},
			onComplete : function (response){
				$("mainContents").update
					(response.responseText);
			}
		});
	}

	$("btnSubmit").observe("click", function(){
		submit();
	});
	
	var checked = [];
	$$("input[type='checkbox']").each(function(c){
		checked.push($(c).id);
	});
</script>
</html>