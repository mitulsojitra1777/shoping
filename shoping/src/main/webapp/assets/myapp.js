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

	default:
		$('#home').addClass('active');
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
	$table.DataTable({
		
		"lengthMenu" : [ [ 3, 5, 10, -1 ],
				[ '3 product', '5 product', '10 product', 'all' ] ],
		"pageLength" : 5,
		"bDestroy": true,
        "deferRender": true ,
		'dataSrc':'object',
		"ajax" : {
			"url" : jsonurl,
		    "dataSrc": "",
			"columns" : [   
{ "data": "id", "name" : "ID", "title" : "ID" ,"":"" },
			                 { data: 'name', name:'name' ,title:'NAME'},
			                 { data: 'brand' , name:'brand' ,title:'BRAND'},
			                 { data: 'descreption' , name:'descreption', title:'DESCREPTION'},
			                 { data: 'quntity' ,name:'quntity', title:'QUNTITY'},
			                 { data: 'unitPrice' , name:'unitPrice' ,title:'UNITPRIZE'},
			                 { data: 'purchases' ,name : 'purchases' ,title:'PURCHES'},
			                 { data: 'views' ,name:'views' ,title:'VIEWS'},
			                 { data: 'id', name:'id'  ,title:'ID'}
			],
			 
		
		}
	 
	});
	
}