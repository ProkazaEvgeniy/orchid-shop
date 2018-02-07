<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/static/css/app-product.css" />
<!-- /CSS -->
<div id="page-wrapper">
	<div class="col-lg-8">
		<div class="well product">
			<div class="price" data-toggle="tooltip" title="Гривна">${product.price }грн</div>
			<img class="thumbnail img-responsive center-block" alt="${product.name }" src=${product.photo } />
			<span> 
						Название: ${product.name } <br> 
						Категория: ${product.category.name } <br>
						Производитель: ${product.producer.name } <br>
			</span>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			<form role="form">
                    <header>
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a data-toggle="tab" href="#stats">Заказ</a>
                            </li>
                            <li class="disabled">
                                <a data-toggle="tab" href="#report">Клиент</a>
                            </li>
                        </ul>
                    </header>
                    <div class="body tab-content">
                        <div class="tab-pane clearfix active" id="stats">
                        	<div class="form-group">
								<label>Данные заказчика совпадают с данными клиента</label>
								<div class="checkbox">
									<label> <input type="checkbox" value="true">Yes</label>
								</div>
							</div>
			                <div class="form-group">
								<label>First name</label> <input class="form-control" placeholder="Enter first name">
							</div>
							<div class="form-group">
								<label>Last name</label> <input class="form-control" placeholder="Enter last name">
							</div>
							<div class="form-group">
								<label>Phone</label> <input class="form-control" placeholder="Enter your phone">
							</div>
							<div class="form-group">
								<label>City</label> <input class="form-control" placeholder="Enter your city">
							</div>
							<div class="form-group">
								<label>Address</label> <input class="form-control" placeholder="Enter your address">
							</div>
							<div class="form-group">
								<label>Select payment method</label> 
								<select class="form-control">
									<option>cash</option>
									<option>credit card</option>
									<option>webmoney</option>
									<option>qiwi</option>
									<option>yandex</option>
								</select>
							</div>
							<div class="form-group">
								<label>Comment to order</label>
								<textarea class="form-control" rows="3"></textarea>
							</div>
                        </div>
                        <div class="tab-pane" id="report">
                            <div class="form-group">
								<label>First name</label> <input class="form-control" placeholder="Enter first name">
							</div>
							<div class="form-group">
								<label>Last name</label> <input class="form-control" placeholder="Enter last name">
							</div>
							<div class="form-group">
								<label>Phone</label> <input class="form-control" placeholder="Enter phone">
							</div>
							<div class="form-group">
								<label>City</label> <input class="form-control" placeholder="Enter city">
							</div>
							<div class="form-group">
								<label>Address</label> <input class="form-control" placeholder="Enter address">
							</div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
	<div class="col-lg-12" style="padding-top: 15px;">
		<div class="bs-example">
			<ul class="nav nav-tabs" style="margin-bottom: 15px;">
				<li class="active"><a href="#description" data-toggle="tab">Description</a></li>
				<li><a href="#comment" data-toggle="tab">Comment</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active in" id="description">
					<p>${product.description }</p>
				</div>
				<div class="tab-pane fade" id="comment">
					<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko
						farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna
						delectus mollit.
					</p>
					<a href="#"><span class="avatar"><i class="fa fa-google-plus"></i></span></a>
					<a href="#"><span class="avatar"><i class="fa fa-facebook"></i></span></a>
					<hr>
					<!-- the comment box -->
					<div class="well">
						<h4>Leave a Comment:</h4>
						<form role="form">
							<div class="form-group">
								<textarea class="form-control" rows="3"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
					<!-- the comments -->
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>