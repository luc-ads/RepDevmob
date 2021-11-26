var ctx = document.getElementById('myChart2').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['09', '10', '11', '12', '14', '15', '16'],
            datasets: [{
                label: 'Comprometimento',
                data: [10, 90, 70, 34, 55, 4, 93, 40],
                fill: true,
                backgroundColor: gradient,
                borderColor: 'rgb(102, 56, 84)',
                borderWidth: 1,
                pointBackgroundColor: 'rgb(169, 169, 169)',
                hoverRadius: 7,
                hitRadius: 15,
                responsive: true,
                tension: 0.2
                
            }],
        },
        options: {
            hoverRadius: 30,
            responsive: true,
            scales: {
                y: {
                    ticks: {
                        callback: function(value) {
                            return value + " °C";
                        },
                    },
                },
            },
        },
    });

    var ctx = document.getElementById('myChart3').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['09', '10', '11', '12', '14', '15', '16'],
            datasets: [{
                label: 'Espaço utilizado',
                data: [25, 5, 90, 44, 33, 88, 21, 99],
                fill: true,
                backgroundColor: gradient,
                borderColor: 'rgb(102, 56, 84)',
                borderWidth: 1,
                pointBackgroundColor: 'rgb(169, 169, 169)',
                hoverRadius: 7,
                hitRadius: 15,
                responsive: true,
                tension: 0.2
                
            }],
        },
        options: {
            hoverRadius: 30,
            responsive: true,
            scales: {
                y: {
                    ticks: {
                        callback: function(value) {
                            return value + " °C";
                        },
                    },
                },
            },
        },
    });