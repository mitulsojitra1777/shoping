<br/>
<ol class="breadcrumb">
		<li><a href="${contextRoot}/home">Home</a> </li>

		<li><a href="${contextRoot}/show/all/product">product</a> </li>

		<li class="active">${product.name}</li>
	</ol>
			<div class="row">
				
				<div class="col-lg-3">
				<%@include file="../public/sidebar.jsp" %>
				</div>
				<!-- /.col-lg-3 -->

				<div class="col-lg-9">
					<div class="content">

					<table id="productListTable" class="table table-striped table-borderd">
						<thead>
							<tr>
							 <th> </th>
			                 <th>name</th>
			                 <th>brand</th>
			                
			                 <th>quntity</th>
			                 <th>unitPrice</th>
			                
							 <th> </th>
							</tr>
						</thead>
					</table>

				</div>
			</div>
			</div>


