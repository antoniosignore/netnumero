var lNd = '<b>Push Buttons:<\/b>', mNd = '<br><br><b>Toggle Buttons:<\/b>', oNd = 'cwCustomButton-push-disabled', nNd = 'cwCustomButton-push-normal', qNd = 'cwCustomButton-toggle-disabled', pNd = 'cwCustomButton-toggle-normal';
_ = I2b.prototype;
_.bc = function M2b() {
    var a, b, c, d, e, f, g;
    mEb(this.a, (g = new OMc, e = new bAc, e.e[Uid] = 10, f = new bAc, f.e[Uid] = 10, LMc(g, new bvc(lNd)), LMc(g, e), LMc(g, new bvc(mNd)), LMc(g, f), c = new sFc(new Nkc((kFb(), IGb(), AGb(), uGb))), kMc(c.Q, w5c, nNd), $zc(e, c), a = new sFc(new Nkc(uGb)), kMc(a.Q, w5c, oNd), Pqc(a, false), $zc(e, a), d = new rKc(new Nkc(uGb)), kMc(d.Q, w5c, pNd), $zc(f, d), b = new rKc(new Nkc(uGb)), kMc(b.Q, w5c, qNd), Pqc(b, false), $zc(f, b), g))
};
function Pqc(a, b) {
    var c;
    if (!a.Q[kLd] != b) {
        c = (!a.b && Iqc(a, a.j), a.b.a) ^ 4;
        c &= -3;
        Jqc(a, c);
        a.Q[kLd] = !b;
        if (b) {
            Hqc(a, (!a.b && Iqc(a, a.j), a.b))
        } else {
            Eqc(a);
            a.Q.removeAttribute(rNd)
        }
    }
}
s5c(sj)(42);