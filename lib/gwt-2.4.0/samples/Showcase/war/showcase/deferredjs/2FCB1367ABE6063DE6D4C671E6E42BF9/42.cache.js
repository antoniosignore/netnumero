_ = Jlb.prototype;
_.fc = function Nlb() {
    var a, b, c, d, e, f, g;
    JX(this.b, (g = new C2b, e = new cSb, e.f[Tqc] = 10, f = new cSb, f.f[Tqc] = 10, z2b(g, new fNb('<b>Push Buttons:<\/b>')), z2b(g, e), z2b(g, new fNb('<br><br><b>Toggle Buttons:<\/b>')), z2b(g, f), c = new qXb(new bDb((YZ(), MZ))), $1b(c.R, $mc, 'cwCustomButton-push-normal'), _Rb(e, c), a = new qXb(new bDb(MZ)), $1b(a.R, $mc, 'cwCustomButton-push-disabled'), TIb(a, false), _Rb(e, a), d = new j0b(new bDb(MZ)), $1b(d.R, $mc, 'cwCustomButton-toggle-normal'), _Rb(f, d), b = new j0b(new bDb(MZ)), $1b(b.R, $mc, 'cwCustomButton-toggle-disabled'), TIb(b, false), _Rb(f, b), g))
};
function TIb(a, b) {
    var c;
    if (!a.R[mwc] != b) {
        c = (!a.c && MIb(a, a.k), a.c.b) ^ 4;
        c &= -3;
        NIb(a, c);
        a.R[mwc] = !b;
        if (b) {
            LIb(a, (!a.c && MIb(a, a.k), a.c))
        } else {
            IIb(a);
            a.R.removeAttribute(Nwc)
        }
    }
}
Ymc(Hj)(42);