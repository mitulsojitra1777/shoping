$(function() {
	// solving the active menu problame
	switch (menu) {
	case 'home':
		$('#home').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'about':
		$('#about').addClass('active');
		break;
	
	case 'manageProduct':
		$('#about').addClass('active');
		break;
		
	case 'allProdut':
		$('#liproduct').addClass('active');
		break;
		
	case 'Manage-Products':
		$('#manageProduct').addClass('active');
		break;
		
	}
	

});

// code for js datatable
// create a deta source

var $table = $('#productListTable');

if ($table.length) {
	var jsonurl = '';
	if (window.catogeryId == '') {
		jsonurl = window.contextRoot + '/json/data/all/product'
	} else {
		jsonurl = window.contextRoot + '/json/data/category/'
				+ window.catogeryId + '/product';
		window.catogeryId = '';

	}
	window.alert(jsonurl);
	$table
			.DataTable({

				"columns" : [
						{
							data : 'code',
							bSortable : false,
							"mRender" : function(data, type, row) {

								return ' <img src="'
										+ window.contextRoot
										+ '/resources/images/'
										+ data
										+ '.jpg" class="image-responcive">';

							}
						},
						{
							data : 'name'
						},
						{
							data : 'brand'
						},

						{
							data : 'quntity',
							"mRender" : function(data, type, row) {
								if (data < 1) {
									window.addcart = false;
									return '<span  style="color:red">Out Of Stock !</span>';

								} else {
									window.addcart = true;
									return '<span  style="color:black">' + data
											+ '</span>';
								}
							}

						},
						{
							data : 'unitPrice'
						},

						{
							data : 'id',
							"mData" : "id",
							bSortable : false,
							"mRender" : function(data, type, row) {
								var str = "";
								if (window.addcart) {
									str += ' <a href="'
										+ window.contextRoot
										+ '/add/'
										+ data
										+ '/cart" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								
								}
								else{
									str += ' <a href="'
										+ window.contextRoot
										+ '/add/'
										+ data
										+ '/cart" class="btn btn-primary disabled"><strike><span class="glyphicon glyphicon-shopping-cart disabled"></span></strike></a>';
									
								}
								
								str += ' <a href="'
									+ window.contextRoot
									+ '/show/'
									+ data
									+ '/products" class="btn btn-success "><span class="glyphicon glyphicon-eye-open"></span></a>';
								return str;
							}

						}

				],
				"lengthMenu" : [ [ 3, 5, 10, -1 ],
						[ '3 product', '5 product', '10 product', 'all' ] ],
				"pageLength" : 5,

				'dataSrc' : '',
				"ajax" : {
					"url" : jsonurl,
					"type" : "GET",
					"dataSrc" : "",

				},

			});

	var $alert=('.alert');
	if($alert.lengrh){
		
		setTimeout( function(){
			$alert.fadeOut('show');
		} , 3000)
		
	}
}

