document.querySelector('.img-btn').addEventListener('click', function()
	{
		document.querySelector('.cont').classList.toggle('s-signup')
	}
);

	function entrar_corp() {
		if (inp_email_corp.value == "admin" && inp_password_corp.value == "12345") {
			window.location.href = 'home_manager.html';
			
		} else {
			alert("Erro nos dados de email ou senha!")
			
		}
	}

	function entrar_fun() {
		if (inp_email_fun.value == "admin" && inp_password_fun.value == "12345") {
			window.location.href = 'perfil_funcionario.html';
			
		} else {
			alert("Erro nos dados de email ou senha!")
			
		}
	}
