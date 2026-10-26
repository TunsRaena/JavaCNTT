
public class PhanSo {
    private int tuSo;
    private int mauSo;
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }
    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0!");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon();
    }
    public int getTuSo() {
        return tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }
    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
        rutGon();
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0!");
        }
        this.mauSo = mauSo;
        rutGon();
    }
    private int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public void rutGon() {
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }

        int ucln = ucln(tuSo, mauSo);

        if (ucln != 0) {
            tuSo /= ucln;
            mauSo /= ucln;
        }
    }
    public PhanSo cong(PhanSo p) {
        return new PhanSo(
            tuSo * p.mauSo + p.tuSo * mauSo,
            mauSo * p.mauSo
        );
    }
    public PhanSo tru(PhanSo p) {
        return new PhanSo(
            tuSo * p.mauSo - p.tuSo * mauSo,
            mauSo * p.mauSo
        );
    }
    public PhanSo nhan(PhanSo p) {
        return new PhanSo(
            tuSo * p.tuSo,
            mauSo * p.mauSo
        );
    }
    public PhanSo chia(PhanSo p) {
        if (p.tuSo == 0) {
            throw new ArithmeticException(
                "Khong the chia cho phan so 0!"
            );
        }

        return new PhanSo(
            tuSo * p.mauSo,
            mauSo * p.tuSo
        );
    }
    public int soSanh(PhanSo p) {
        long a = (long) tuSo * p.mauSo;
        long b = (long) p.tuSo * mauSo;
        return Long.compare(a, b);
    }
    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }
    @Override
    public String toString() {
        if (mauSo == 1) {
            return String.valueOf(tuSo);
        }
        return tuSo + "/" + mauSo;
    }
}
