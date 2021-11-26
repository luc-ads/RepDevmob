let login_usuario;
let nome_usuario;

function redirecionar_login() {
    window.location.href = 'index.html';
}

function verificar_autenticacao() {
    login_usuario = sessionStorage.company_email_meuapp;
    nome_usuario = sessionStorage.company_name_meuapp;
    
    if (login_usuario == undefined)  {
        redirecionar_login();
    } else {
        validar_sessao();
    }
    
}

//function logoff() {
//    finalizar_sessao();
//    sessionStorage.clear();
//    redirecionar_login();
//}

function validar_sessao() {
    fetch(`/empresas/session/${login_usuario}`, {cache:'no-store'})
    .then(resposta => {
        if (resposta.ok) {
            resposta.text().then(texto => {
                console.log('Sessão :) ', texto);    
            });
        } else {
            console.error('Sessão :.( ');
            finalizar_sessao();
        } 
    });    
}

function finalizar_sessao() {
    fetch(`/empresas/logoff/${login_usuario}`, {cache:'no-store'});
    sessionStorage.clear();
    redirecionar_login(); 
}