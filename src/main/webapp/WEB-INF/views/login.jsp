<%@ include file="/WEB-INF/views/header.jspf" %>
	<section>
		
	</section>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			 	</div>
			  	<div class="panel-body">
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
				
								
			    	<form action="login" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form:input-large" placeholder="User Name" name='username' type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class=" form:input-large" placeholder="Password" name='password'  type="password" value="">
			    		</div>
			    		<input  type="submit" value="Login">
			    		<a href='<spring:url value="signup" />'>Signup</a>
			    		
			    	</fieldset>
						<security:csrfInput />
			      	</form>
			      	
			    </div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jspf" %>

