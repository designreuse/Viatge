<!-- Modal Novo Destino Requisitado-->
<div class="modal fade">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" ng-click="close()"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Negociar Novo Destino</h4>
			</div>
			<div class="modal-body">
				<div class="aling-form col-sm-12 nest text"
					style="padding-top: 25px">
					<form>
						<div class="box01">
							<select id="destination-passenger-list" class="form-control">
								<option value=""></option>
							</select>
						</div>

						<div class="box02">
							<div class="input-group ">
								<span id="span-arrive" class="input-group-addon btn-success"><i
									class="fa fa-calendar"></i></span> <input id="see-in" type="text"
									name="" class="form-control" placeholder="Ver em..." />
							</div>
						</div>

						<div class="box01">
							<div class="input-group ">
								<span id="span-departure" class="input-group-addon btn-success"><i
									class="fa fa-calendar"></i></span> <input id="input-departure"
									type="text" name="" class="form-control"
									placeholder="Data de Ida" />
							</div>
						</div>

						<div class="box02">
							<div class="input-group ">
								<span id="span-arrive" class="input-group-addon btn-success"><i
									class="fa fa-calendar"></i></span> <input id="input-arrive"
									type="text" name="" class="form-control"
									placeholder="Data de Volta" />
							</div>
						</div>

						<div class="box01">
							<select id="combo-saleType" class="form-control" name="">
								<option value=""></option>
							</select>
						</div>

						<div class="box02">
							<div class="input-group ">
								<span class="input-group-addon btn-success"><i
									class="fa fa-money"></i></span> <input id="input-price" type="text"
									data-thousands="." data-decimal="," name=""
									class="form-control" />
							</div>
						</div>
						<div class="box03">
							<textarea id="destination-observations" name="" rows="3"
								placeholder="ObservaÃ§Ãµes..." class="form-control"
								style="min-height: 130px;"></textarea>
						</div>

						<div class="box02">
							<div class="input-group skin skin-flat">
								<input id="ckb-requested" type="checkbox" name="" /> <label
									id="ckb-label" for="ckb-requested">Destino Solicitado
									pelo Passageiro?</label>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer clear" style="margin: 0px;">
				<button ng-click="close()" class="btn btn-primary"
					data-dismiss="modal">Cadastrar</button>
				<button ng-click="cancel()" class="btn btn-danger">Cancelar</button>
			</div>
		</div>
	</div>
</div>