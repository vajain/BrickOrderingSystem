<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8" /> 
    <title> Product Selection </title>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-resource.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/productSelection.js"></script>
	<style>
		div.contr {
			float:left; 
			width:50%; 
			height:500px; 
			background:silver
		}

		div.header1{
			text-align:center;
			padding-top:20px
		}
		div.mainDiv{
			padding-right:40px;
			padding-left:40px;
			padding-top :40px
		}
		div.basketCtr{
			float:right; 
			width:50%;height:500px; 
			background:lightgrey
		}
		div.basketHdr{
			text-align:center;
			padding-top:20px
		}
		div.btn{
			float:right;
			padding-right:20px;
			padding-bottom:20px
		}
	</style>
	
	
  </head>
  <body ng-app="myApp">
    <div ng-controller="ShoppingAppController" class="mainDiv">
		<div class="contr">
			<div class="header1"><b> Select products</b></div><br><br>
			<div ng-repeat="row in products">
				<input type="checkbox" ng-model="product.isSelected" ng-change="value(product.isSelected,row)"/>{{row.category}} - {{row.product}}
			</div>
		</div>
		<div class="basketCtr">
			<div class="basketHdr"><b>Basket</b><br><br></div>
			<div ng-repeat="y in selectedItems" ng-show="selectedItems.length>0">
				{{y.category}} - {{y.product}}
			</div>
			
			<div ng-show="selectedItems.length>0" class= "btn"><button ng-click="clicked()" > Checkout</button></div>
	
		</div>
	</div>
       
 </body>
</html>