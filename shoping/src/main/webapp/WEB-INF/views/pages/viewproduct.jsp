<br />
<br />

<div class="col-xs-12">

	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnaul">
				<img src="${contextRoot}/resources/images/${product.code}.jpg"
					class="image-responcive">
			</div>



		</div>
		<div class="col-xs-12 col-sm-8">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>

				<li><a href="${contextRoot}/show/all/product">product</a></li>

				<li class="active">${product.name}</li>
			</ol>
			<h1>${product.name}</h1>
			<hr />
			<h3>${product.descreption}</h3>
			<hr />
			<h2>price : ${product.unitPrice}</h2>
			<hr />
			<c:choose>
				<c:when test="${product.quntity <1}">
					<H6>
						Quntity avalable : <span color="red">out of stock</span>
					</H6>
					<hr />
				</c:when>
				<c:otherwise>
					<H6>Quntity avalable : ${product.quntity}</H6>
					<hr />
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${product.quntity <1}">
					<a href="${contextRoot}/add/${product.id}/cart"
						class="btn btn-primary disabled"><strike><span
							class="glyphicon glyphicon-shopping-cart"> Add to cart</span></strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/add/${product.id}/cart"
						class="btn btn-primary"><span
						class="glyphicon glyphicon-shopping-cart"> Add to cart</span></a>
				</c:otherwise>
			</c:choose>



			<a href="${contextRoot}/show/all/product" class="btn btn-success">Back</a>
		</div>

	</div>
</div>
</div>