public class frameformat
{
    protected int preamble;
    protected int sd;
    protected int fc;
    protected int dest_add;
    protected int sour_add;
    protected String data;
    protected int checksum;
    protected int ed;

    // Setting

    void set_preamble(int dt)
    {
        preamble = dt;
    }

    void set_sd(int dt)
    {
        sd = dt;
    }

    void set_fc(int dt)
    {
        fc = dt;
    }

    void set_dest_add(int dt)
    {
        dest_add = dt;
    }

    void set_sour_add(int dt)
    {
        sour_add = dt;
    }

    void set_data(String dt)
    {
        data = dt;
    }

    void set_checksum(int dt)
    {
        checksum = dt;
    }

    void set_ed(int dt)
    {
        ed = dt;
    }


    // Getting

    int get_preamble()
    {
        return preamble;
    }

    int get_sd()
    {
        return sd;
    }

    int get_fc()
    {
        return fc;
    }

    int get_dest_add()
    {
        return dest_add;
    }

    int get_sour_add()
    {
        return sour_add;
    }

    String get_data()
    {
        return data;
    }

    int get_checksum()
    {
        return checksum;
    }

    int get_ed()
    {
        return ed;
    }
}