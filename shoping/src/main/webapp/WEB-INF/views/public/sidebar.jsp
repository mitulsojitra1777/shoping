
<h1 class="my-4">Galaxy solution</h1>
<div class="list-group">
	<c:forEach items="${catogeries}" var="catogerie">
		<a href="${contextRoot}/show/catogery/${catogerie.id}/products" class="list-group-item">${catogerie.name}</a>
	</c:forEach>
	
</div>
