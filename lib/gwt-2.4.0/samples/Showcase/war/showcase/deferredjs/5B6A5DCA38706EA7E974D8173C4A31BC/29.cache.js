function Iuc(){}
function cvc(){}
function bvc(){}
function evc(){}
function ivc(){}
function hvc(){}
function Wuc(a,b){a.b=b}
function Xuc(a){if(a==Muc){return true}NA();return a==Puc}
function Yuc(a){if(a==Luc){return true}NA();return a==Kuc}
function fvc(a){this.b=(cxc(),Zwc).a;this.d=(lxc(),kxc).a;this.a=a}
function Zuc(){Quc();koc.call(this);this.b=(cxc(),Zwc);this.c=(lxc(),kxc);this.e[$6c]=0;this.e[_6c]=0}
function Uuc(a,b){var c;c=Egb(a.O,88);c.b=b.a;!!c.c&&(c.c[Y6c]=b.a,undefined)}
function Vuc(a,b){var c;c=Egb(a.O,88);c.d=b.a;!!c.c&&Gkc(c.c,Z6c,b.a)}
function Quc(){Quc=x2c;Juc=new cvc;Muc=new cvc;Luc=new cvc;Kuc=new cvc;Nuc=new cvc;Ouc=new cvc;Puc=new cvc}
function Ruc(a,b,c){var d;if(c==Juc){if(b==a.a){return}else if(a.a){throw new NSc('Only one CENTER widget may be added')}}Pe(b);BKc(a.j,b);c==Juc&&(a.a=b);d=new fvc(c);b.O=d;Uuc(b,a.b);Vuc(b,a.c);Tuc(a);Re(b,a)}
function Suc(a,b){var c,d,e,f,g,i,j;UJc(a.Q,R2c,b);i=new A_c;j=new MKc(a.j);while(j.a<j.b.c-1){c=LKc(j);g=Egb(c.O,88).a;e=Egb(i.Vd(g),132);d=!e?1:e.a;f=g==Nuc?'north'+d:g==Ouc?'south'+d:g==Puc?'west'+d:g==Kuc?'east'+d:g==Muc?'linestart'+d:g==Luc?'lineend'+d:R6c;UJc(Fl(c.Q),b,f);i.Xd(g,dTc(d+1))}}
function Tuc(a){var b,c,d,e,f,g,i,j,k,n,o,p,q,r,s,t;b=a.d;while(b.children.length>0){nl(b,b.children[0])}q=1;e=1;for(i=new MKc(a.j);i.a<i.b.c-1;){d=LKc(i);f=Egb(d.O,88).a;f==Nuc||f==Ouc?++q:(f==Kuc||f==Puc||f==Muc||f==Luc)&&++e}r=tgb(kzb,{124:1,135:1},89,q,0);for(g=0;g<q;++g){r[g]=new ivc;r[g].b=Kl($doc,W6c);jl(b,CCc(r[g].b))}k=0;n=e-1;o=0;s=q-1;c=null;for(i=new MKc(a.j);i.a<i.b.c-1;){d=LKc(i);j=Egb(d.O,88);t=Kl($doc,X6c);j.c=t;j.c[Y6c]=j.b;Gkc(j.c,Z6c,j.d);j.c[U2c]=R2c;j.c[S2c]=R2c;if(j.a==Nuc){zkc(r[o].b,t,r[o].a);jl(t,CCc(d.Q));t[r9c]=n-k+1;++o}else if(j.a==Ouc){zkc(r[s].b,t,r[s].a);jl(t,CCc(d.Q));t[r9c]=n-k+1;--s}else if(j.a==Juc){c=t}else if(Xuc(j.a)){p=r[o];zkc(p.b,t,p.a++);jl(t,CCc(d.Q));t[tcd]=s-o+1;++k}else if(Yuc(j.a)){p=r[o];zkc(p.b,t,p.a);jl(t,CCc(d.Q));t[tcd]=s-o+1;--n}}if(a.a){p=r[o];zkc(p.b,c,p.a);jl(c,CCc(a.a.Q))}}
_=jZb.prototype;_.ac=function nZb(){var a,b,c;uDb(this.a,(b=new Zuc,b.Q[T2c]='cw-DockPanel',b.e[$6c]=4,Wuc(b,(cxc(),Ywc)),Ruc(b,new Zsc('This is the first north component'),(Quc(),Nuc)),Ruc(b,new Zsc('This is the first south component'),Ouc),Ruc(b,new Zsc('This is the east component'),Kuc),Ruc(b,new Zsc('This is the west component'),Puc),Ruc(b,new Zsc('This is the second north component'),Nuc),Ruc(b,new Zsc('This is the second south component'),Ouc),a=new Zsc("This is a <code>ScrollPanel<\/code> contained at the center of a <code>DockPanel<\/code>.  By putting some fairly large contents in the middle and setting its size explicitly, it becomes a scrollable area within the page, but without requiring the use of an IFRAME.<br><br>Here's quite a bit more meaningless text that will serve primarily to make this thing scroll off the bottom of its visible area.  Otherwise, you might have to make it really, really small in order to see the nifty scroll bars!"),c=new wpc(a),c.Q.style[U2c]=dbd,c.Q.style[S2c]=scd,Ruc(b,c,Juc),Suc(b,'cwDockPanel'),b))};_=Zuc.prototype=Iuc.prototype=new hoc;_.gC=function $uc(){return Ttb};_.tb=function _uc(a){Suc(this,a)};_.Lb=function avc(a){var b;b=Qmc(this,a);if(b){a==this.a&&(this.a=null);Tuc(this)}return b};_.cM={40:1,46:1,84:1,91:1,92:1,95:1,110:1,112:1};_.a=null;var Juc,Kuc,Luc,Muc,Nuc,Ouc,Puc;_=cvc.prototype=bvc.prototype=new Y;_.gC=function dvc(){return Qtb};_=fvc.prototype=evc.prototype=new Y;_.gC=function gvc(){return Rtb};_.cM={88:1};_.a=null;_.c=null;_=ivc.prototype=hvc.prototype=new Y;_.gC=function jvc(){return Stb};_.cM={89:1};_.a=0;_.b=null;var Ttb=wSc(J7c,'DockPanel'),Stb=wSc(J7c,'DockPanel$TmpRow'),kzb=vSc(r8c,'DockPanel$TmpRow;',Stb),Qtb=wSc(J7c,'DockPanel$DockLayoutConstant'),Rtb=wSc(J7c,'DockPanel$LayoutData');P2c(sj)(29);