<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>


<html>
<head>

<title> List Artist  </title>

	<!-- reference style sheet -->
	<link type ="text/css"
	       rel="stylesheet"
	       href="${pageContext.request.contextPath}/resources/css/list-artist.css" />

<body>

<div id="wrapper"> 
<div id="header">
<h2> ARM -- Artist Relationship Manager </h2>

</div>
</div>

<div id="container" >

<div id="content" >


		<!-- Put new button add Artist -->

			<input type="button" value="Add Artist"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
			/> 



     <!--  HTMl table -->
 <table>
		<tr>
			<th> Name </th>  
			<th> Song </th>  
			<th> Year </th>
			<th> Genre </th>
			<th> Action </th>
		</tr>
		
		
		<!--   loop over and print the artists -->
		<c:forEach var="tempArtist"   items="${artists}"> 
		
		
		<!--   construct an "update" link with artist id -->
		<c:url var="updateLink" value="/artist/showFormForUpdate">
		 <c:param name="artistId" value="${tempArtist.id}"/>
		 </c:url>
		
		<!--   construct an "delete" link with artist id -->
		<c:url var="deleteLink" value="/artist/delete">
		 <c:param name="artistId" value="${tempArtist.id}"/>
		 </c:url>
		 
			<tr>
				<td> ${tempArtist.name} </td>
				<td> ${tempArtist.song} </td>
				<td> ${tempArtist.year} </td>
				<td> ${tempArtist.genre} </td>
			
				<td>
				<!-- display the update link -->
				<a href="${updateLink}">Update</a>
				|
				<a href="${deleteLink}"
				onclick="if(!(confirm('Are you sure you want to delete this  artist ?'))) return false">Delete</a>
				
				 </td>
			</tr>

 	 	</c:forEach>

</table>

</div>
</div>

</body>
</head>
</html>