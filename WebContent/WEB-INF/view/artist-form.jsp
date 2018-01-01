<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>


<!DOCTYPE html>

<html>

<head> 

<title>  Save Artist </title>

	<link type ="text/css"
	       rel="stylesheet"
	       href="${pageContext.request.contextPath}/resources/css/list-artist.css" />
	       
	       
	 <link type ="text/css"
	       rel="stylesheet"
	       href="${pageContext.request.contextPath}/resources/css/add-artist-style.css" />

</head>

<body>

   		<div id="wrapper"> 
		   	<div id="header">
		      <h2> ARM -- Artist Relationship Manager </h2>
	  </div>
	</div>
	
	<div id="container" >
	   <h3>  Save Artist</h3>

		<form:form action="saveArtist" modelAttribute="artist" method="POST">
		
		<!-- 	need to associate this data with artist id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				
				<tr>
					<td><label>Song:</label></td>
					<td><form:input path="song" /></td>
				</tr>
				
				<tr>
					<td><label>Year:</label></td>
					<td><form:input path="year" /></td>
				</tr>
				
				<tr>
					<td><label>Genre:</label></td>
					<td><form:input path="genre" /></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
				
			</tbody>
		</table>
   </form:form>

   <div style="clear; both;"></div>
   
   <p>
    	<a href="${pageContext.request.contextPath}/artist/list"> Back to list </a>
   </p>

</div>


</body>

</html>