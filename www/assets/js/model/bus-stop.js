export default class BusStop {
    constructor(f, t) {
        this.from = f;
        this.to = t;
    }

    set() {
        let f = this.toBusStopName(this.from);
        let t = this.toBusStopName(this.to);
        $("#bus-stop-from").text(f);
        $("#bus-stop-to").text(t);
    }

    toBusStopName(s) {
        switch (s) {
            case 0:
                return "厚木バスセンター";
            case 1:
                return "厚木駅";
            case 2:
                return "大通り";
            case 3:
                return "松蓮寺";
            case 4:
                return "荻野新宿";
            case 5:
                return "神奈川工科大学";
            default:
                return "";
        }
    }
}