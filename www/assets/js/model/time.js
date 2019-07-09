export default class Time {
    constructor(h, m) {
        this.hour = h;
        this.minute = m;
    }

    set() {
        $("#hour").text(this.hour);
        $("#minute").text(this.minute);
    };
}
