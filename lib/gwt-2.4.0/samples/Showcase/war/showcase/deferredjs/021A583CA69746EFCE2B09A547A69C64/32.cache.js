var O1c = '3px solid #e7e7e7', V1c = 'This is some text to show how the contents on either side of the splitter flow.', R1c = 'This is the east component.', P1c = 'This is the first north component.', Q1c = 'This is the first south component.', T1c = 'This is the second north component.', U1c = 'This is the second south component.', S1c = 'This is the west component.', N1c = 'cwSplitLayoutPanel';
function $ib() {
    var a, b, c, d, e;
    e = new D_b(5);
    p4b(e.Q, Bpc, N1c);
    e.Q.style[Dwc] = O1c;
    y_b(e, new _Ob(P1c), (JQb(), GQb), 50, null);
    y_b(e, new _Ob(Q1c), HQb, 50, null);
    y_b(e, new _Ob(R1c), DQb, 100, null);
    y_b(e, new _Ob(S1c), IQb, 100, null);
    y_b(e, new _Ob(T1c), GQb, 50, null);
    y_b(e, new _Ob(U1c), HQb, 50, null);
    c = V1c;
    for (d = 0; d < 3; ++d) {
        c += sqc + c
    }
    a = new _Ob(c);
    b = new FLb(a);
    y_b(e, b, CQb, 0, null);
    return e
}
_ = ejb.prototype;
_.bc = function ijb() {
    rY(this.a, $ib())
};
xpc(sj)(32);