function hEb() {
}
function fFb() {
}
function jFb() {
}
function kFb(a) {
    this.b = a
}
function jEb() {
    this.b = new oOc
}
function gFb(a, b) {
    this.b = a;
    this.c = b
}
function bFb(b) {
    var a, c, d;
    d = EGc(Kl(b.b.R, oXc));
    if (rGc(d, FRc)) {
        uoc(b.d, '< \u0627\u0644\u0631\u062C\u0627\u0621 \u0627\u062F\u062E\u0627\u0644 \u0627\u0633\u0645 \u0627\u0644\u0637\u0631\u064A\u0642\u0629 \u0627\u0639\u0644\u0627\u0647 >')
    } else {
        try {
            c = iEb(b.c, d);
            uoc(b.d, c)
        } catch (a) {
            a = Dmb(a);
            if (Y3(a, 150)) {
                uoc(b.d, '<\u063A\u064A\u0631 \u0645\u0648\u062C\u0648\u062F>')
            } else throw a
        }
    }
}
function iEb(a, b) {
    var c;
    c = W3(a.b.Zd(b), 1);
    if (c != null) {
        return c
    }
    if (rGc(b, VXc)) {
        a.b._d(VXc, qYc);
        return qYc
    }
    if (rGc(b, kYc)) {
        a.b._d(kYc, sYc);
        return sYc
    }
    if (rGc(b, hYc)) {
        a.b._d(hYc, nYc);
        return nYc
    }
    if (rGc(b, iYc)) {
        a.b._d(iYc, oYc);
        return oYc
    }
    if (rGc(b, lYc)) {
        a.b._d(lYc, tYc);
        return tYc
    }
    if (rGc(b, jYc)) {
        a.b._d(jYc, rYc);
        return rYc
    }
    if (rGc(b, WXc)) {
        a.b._d(WXc, mYc);
        return mYc
    }
    if (rGc(b, XXc)) {
        a.b._d(XXc, pYc);
        return pYc
    }
    throw new wPc("Cannot find constant '" + b + "'; expecting a method name")
}
function aFb(a) {
    var b, c, d, e, f;
    a.c = new jEb;
    c = new Fic;
    b = W3(c.k, 90);
    c.p[KVc] = 5;
    f = Upb(obb);
    d = new tac(f);
    We(d, new gFb(a, f), (Cq(), Cq(), Bq));
    e = new Jkc;
    e.f[KVc] = 3;
    Gkc(e, new Mfc(eYc));
    Gkc(e, d);
    yic(c, 0, 0, e);
    Pic(b, 0)[YXc] = 2;
    a.b = new Goc;
    uoc(a.b, WXc);
    Ee(a.b, fYc);
    vic(c, 1, 0, '<b>\u0627\u0633\u0645 \u0627\u0644\u0637\u0631\u064A\u0642\u0629:<\/b>');
    yic(c, 1, 1, a.b);
    a.d = new Goc;
    jac(a.d, false);
    Ee(a.d, fYc);
    vic(c, 2, 0, '<b>\u0646\u062A\u0627\u0626\u062C \u0627\u0644\u0628\u062D\u062B:<\/b>');
    yic(c, 2, 1, a.d);
    We(a.b, new kFb(a), (wr(), wr(), vr));
    bFb(a);
    return c
}
_ = jEb.prototype = hEb.prototype = new Y;
_.gC = function kEb() {
    return nbb
};
_ = gFb.prototype = fFb.prototype = new Y;
_.gC = function hFb() {
    return ybb
};
_.sc = function iFb(a) {
    Mpb(this.b, this.c + dYc)
};
_.cM = {22: 1, 44: 1};
_.b = null;
_.c = null;
_ = kFb.prototype = jFb.prototype = new Y;
_.gC = function lFb() {
    return zbb
};
_.uc = function mFb(a) {
    bFb(this.b)
};
_.cM = {27: 1, 44: 1};
_.b = null;
_ = nFb.prototype;
_.fc = function rFb() {
    oqb(this.c, aFb(this.b))
};
var nbb = kFc(OWc, 'ColorConstants_ar'), obb = mFc(OWc, 'ColorConstants'), ybb = kFc(OWc, 'CwConstantsWithLookupExample$1'), zbb = kFc(OWc, 'CwConstantsWithLookupExample$2');
DRc(Hj)(11);