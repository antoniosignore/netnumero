function wcb() {
}
function Acb() {
}
function Bcb(a) {
    this.a = a
}
function xcb(a, b) {
    this.a = a;
    this.b = b
}
function scb(a) {
    var b, c, d;
    b = yec(tl(a.a.Q, kPc));
    c = yec(tl(a.b.Q, kPc));
    d = yec(tl(a.c.Q, kPc));
    YOb(a.d, oVc + b + pVc + c + qVc + d + kuc)
}
function rcb(a) {
    var b, c, d, e, f, g;
    d = new cSb;
    b = wC(d.j, 90);
    d.o[YCc] = 5;
    g = XX(kJ);
    e = new PJb(g);
    Ie(e, new xcb(a, g), (xq(), xq(), wq));
    f = new gUb;
    f.e[YCc] = 3;
    dUb(f, new gPb(uTc));
    dUb(f, e);
    XRb(d, 0, 0, f);
    mSb(b, 0)[vTc] = 2;
    URb(d, 1, 0, wTc);
    URb(d, 1, 1, jVc);
    a.a = new gYb;
    WXb(a.a, kVc);
    URb(d, 2, 0, zTc);
    XRb(d, 2, 1, a.a);
    a.b = new gYb;
    WXb(a.b, lVc);
    URb(d, 3, 0, BTc);
    XRb(d, 3, 1, a.b);
    a.c = new gYb;
    WXb(a.c, mVc);
    URb(d, 4, 0, DTc);
    XRb(d, 4, 1, a.c);
    a.d = new ePb;
    URb(d, 5, 0, nVc);
    XRb(d, 5, 1, a.d);
    rSb(b, 5, 0, (xTb(), wTb));
    c = new Bcb(a);
    Ie(a.a, c, (rr(), rr(), qr));
    Ie(a.b, c, qr);
    Ie(a.c, c, qr);
    scb(a);
    return d
}
var qVc = "' and cannot access '", pVc = "' has security clearance '", mVc = '/secure/blueprints.xml', sVc = 'CwMessagesExample$1', tVc = 'CwMessagesExample$2', rVc = 'ErrorMessages', oVc = "User '", jVc = "User '{0}' has security clearance '{1}' and cannot access '{2}'", kVc = 'amelie', lVc = 'guest';
_ = xcb.prototype = wcb.prototype = new Y;
_.gC = function ycb() {
    return ZI
};
_.qc = function zcb(a) {
    PX(this.a, this.b + JTc)
};
_.cM = {22: 1, 44: 1};
_.a = null;
_.b = null;
_ = Bcb.prototype = Acb.prototype = new Y;
_.gC = function Ccb() {
    return $I
};
_.sc = function Dcb(a) {
    scb(this.a)
};
_.cM = {27: 1, 44: 1};
_.a = null;
_ = Ecb.prototype;
_.bc = function Icb() {
    rY(this.b, rcb(this.a))
};
var kJ = gdc(RIc, rVc), ZI = edc(RIc, sVc), $I = edc(RIc, tVc);
xpc(sj)(14);