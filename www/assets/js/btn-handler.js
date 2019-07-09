import Time from './model/time.js'
import BusStop from './model/bus-stop.js'

$('#btn-campus').click(function () {
    let direction = 0;
    get(direction);
    revColor(direction);
});

$('#btn-station').click(function () {
    let direction = 1;
    get(direction);
    revColor(direction);
});

function get(direction) {
    const path = '/api/get/next/?';
    const params = new URLSearchParams();
    params.set('direction', direction);
    const uri = path + params.toString();

    fetch(uri)
        .then(response => {
            $('.error').css('visibility', 'hidden');
            return response.json();
        })
        .then(json => {
            new Time(json.time.hour, json.time.minute).set();
            new BusStop(json.from, json.to).set();
        })
        .catch(error => {
            new Time('', '').set();
            new BusStop('', '').set();
            $('.error').text('通信エラーが発生しました').css('visibility', 'unset');
        });
}

function revColor(s) {
    let nomal = {
        "color": "aliceblue",
        "background": "#ffb74d",
    };
    let reverse = {
        "color": "#ef6c00",
        "background": "linear-gradient(#ffe0b2, aliceblue)",
    };
    $('.direct').css(nomal);

    switch (s) {
        case 0:
            $("#btn-campus").css(reverse);
            break;
        case 1:
            $("#btn-station").css(reverse);
            break;
        default:
            break;

    }
}

revColor(0);
get(0);