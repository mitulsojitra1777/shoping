<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<br />
<br />

<div calss="row">
	<c:if test="${not empty message}">
		<div class="col-lx-12">
			<script type="text/javascript">
				window.alert("${message}")
			</script>
			<div class="alert alert-success alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">&times
				</button>
				${message}
			</div>
		</div>
	</c:if>
	<div class="com-md-offset-2 col-lx-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Product Management</h4>
			</div>
			<div class="panel-body">
				<!-- form element -->
				<sf:form action="${contextRoot}/manage/products"
					class="form-horizontal" modelAttribute="product" method="POST"
					enctype="multipart/form-data">
					<div class="form-group ">
						<label class="control-label col-lx-8" for="name">Enter
							Product Name:</label>
						<div class="cdl-md-4">
							<sf:input type="text" path="name" id="name"
								placeholder="product name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
							<!-- <em class="help-block"> Plese enter product name...</em> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lx-8" for="brand">Enter
							Brand Name:</label>
						<div class="cdl-md-4">
							<sf:input type="text" path="brand" id="brand"
								placeholder="brand name" class="form-control" />
							<sf:errors path="brand" cssClass="help-block" element="em" />
							<!-- <em class="help-block"> Plese enter brand name...</em>  -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lx-8" for="brand">Enter
							Descreption:</label>
						<div class="cdl-md-4">
							<sf:textarea path="descreption" id="descreption" rows="4"
								placeholder="descreption" class="form-control" />
							<sf:errors path="descreption" cssClass="help-block" element="em" />
							<!-- <em class="help-block"> Plese enter product Descreption...</em> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lx-8" for="brand">Enter
							prize:</label>
						<div class="cdl-md-4">
							<sf:input type="number" step="00000.01" path="unitPrice"
								id="unitPrice" placeholder="0.0" class="form-control"
								value="0.0" />
							<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							<!-- <em class="help-block"> Plese enter prize...</em> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lx-8" for="brand">Enter
							quntity:</label>
						<div class="cdl-md-4">
							<sf:input type="number" step="000" path="quntity" id="quntity"
								placeholder="0" class="form-control" value="0.0" />
							<em class="help-block"> Plese enter quntity...</em>
						</div>
					</div>
					<!-- file element -->
					<div class="form-group">
						<label class="control-label col-lx-8" for="file">Select an
							Immage:</label>
						<div class="cdl-md-4">
							<sf:input type="file" path="file" id="file" class="form-control"
								/>
								<sf:errors path="file" cssClass="help-block" element="em" />

						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lx-8" for="brand">category:</label>
						<div class="cdl-md-4">
							<sf:select path="categoryid" id="categoryid" class="form-control"
								items="${categories}" itemLabel="name" itemValue="id" />
							<sf:errors path="categoryid" cssClass="help-block" element="em" />
							<!-- <em class="help-block"> Plese select category</em>  -->
						</div>
					</div>
					<div class="form-group">

						<div class="cdl-md-offset-4 cdl-md-8">
							<input type="submit" value="submit" class="btn btn-primary" />
							<sf:hidden path="id" />
							<sf:hidden path="active" />
							<sf:hidden path="suplierid" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
							<sf:hidden path="code" />

						</div>
					</div>
				</sf:form>
			</div>
		</div>

	</div>
</div>