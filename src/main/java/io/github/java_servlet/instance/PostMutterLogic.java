package io.github.java_servlet.instance;

import java.util.List;

public class PostMutterLogic {
    public void excute(Mutter mutter) {
        MuttersDAO dao = new MuttersDAO();
        dao.create(mutter);
    }
}