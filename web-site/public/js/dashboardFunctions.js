let proximaAtualizacao;

window.onload = obterDadosGraficoPrimeiraVez(1);

function chamargraficos(idUser) {
    console.log("executei chamargraficos")
    obterDadosGraficoPrimeiraVez(idUser)
    //atualizarGrafico(idcaminhao)
}


verificar_autenticacao();

function configurarGrafico() {
    console.log("Executar configurarGrafico")
    var configuracoes = {
        responsive: true,
        animation: { duration: 500 },
        hoverMode: 'index',
        stacked: false,
        title: {
            display: true,
            text: 'Histórico de temperatura'
        },
        scales: {
            yAxes: {
                type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: 'left',
                id: 'y-temperatura',
            }
        }
    };

    return configuracoes;
}

function obterDadosGraficoPrimeiraVez(idUser) {
    console.log("executei obterDadosGraficoPrimeiraVez")
    alterarCoresBotoes(idUser);

    if (proximaAtualizacao != undefined) {
        clearTimeout(proximaAtualizacao);
    }

    fetch(`/leituras/ultimas/${idUser}`, { cache: 'no-store' }).then(function (response) {
        if (response.ok) {
            response.json().then(function (resposta) {
                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                resposta.reverse();

                var dados = {
                    labels: [],
                    datasets:
                    {
                        yAxisID: 'y-temperatura',
                        label: 'Temperatura',
                        borderColor: 'rgba(255,0,0,1)',
                        backgroundColor: 'rgba(255,0,0,1)',
                        fill: false,
                        data: []
                    }
                };
                for (i = 0; i < resposta.length; i++) {
                    var registro = resposta[i];
                    dados.labels.push(registro.momento_grafico);
                    dados.datasets[0].data.push(registro.temperatura);
                    dados.datasets[1].data.push(registro.umidade);

                }
                console.log(JSON.stringify(dados));
                div_aguarde.style.display = 'none';
                plotarGrafico(dados, idUser);
            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

}

function atualizarGrafico(idUser, dados) {
    console.log("executei atualizarGrafico")
    fetch(`/leituras/tempo-real/${idUser}`, { cache: 'no-store' }).then(function (response) {
        console.log("Estou tentando pegar idcaminhao = ", idUser)
        if (response.ok) {
            response.json().then(function (novoRegistro) {

                console.log(`Dados recebidos: ${JSON.stringify(novoRegistro)}`);
                console.log(`Dados atuais do gráfico: ${dados}`);

                // tirando e colocando valores no gráfico
                dados.labels.shift(); // apagar o primeiro
                dados.labels.push(novoRegistro.momento_grafico); // incluir um novo momento
                dados.datasets[0].data.shift();  // apagar o primeiro de temperatura
                dados.datasets[1].data.shift();  // apagar o primeiro de umidade
                dados.datasets[0].data.push(novoRegistro.temperatura); // incluir uma nova leitura de temperatura
                dados.datasets[1].data.push(novoRegistro.umidade); // incluir uma nova leitura de umidade

                console.log("Meu user é o: " + idUser)

                window.grafico_linha.update();


                proximaAtualizacao = setTimeout(() => atualizarGrafico(idUser, dados), 5000);
            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
            proximaAtualizacao = setTimeout(() => atualizarGrafico(idUser, dados), 5000);
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

}

// só altere aqui se souber o que está fazendo!
function plotarGrafico(dados, idUser) {
    console.log("Executar plotarGrafico")
    console.log('Iniciando plotagem do gráfico...');

    var ctx = canvas_grafico.getContext('2d');
    window.grafico_linha = Chart.Line(ctx, {
        data: dados,
        options: configurarGrafico()
    });

    setTimeout(() => atualizarGrafico(idcaminhao, dados), 2000);
}


function sendData() {
    var http = new XMLHttpRequest();
    http.open('GET', 'http://localhost:9001/api/sendData', false);
    http.send(null);
}

// Descomente abaixo se quiser inserir dados a cada X segundos
setInterval(() => {
    sendData();
}, 2000);