import axios from 'axios';
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';
type ChartData = {
    labels: string[];
    series: number[];
}
function DonutChart() {
    //Forma erra de proceder...
    let charData: ChartData = { labels: [], series: [] };

    //BASE_URL + '/sales/sumbyseller'
    //Forma errada  //Chamada assyncrona ou seja o programa nao fica a espera da resposta
    axios.get(`${BASE_URL}/sales/sumbyseller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            charData = { labels: myLabels, series: mySeries};

            console.log(charData);
        });

    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart options={{ ...options, labels: charData.labels }} series={charData.series} type="donut" height="240" />

    );
}

export default DonutChart;