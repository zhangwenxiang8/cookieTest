package work.utilTest;

import java.sql.ResultSet;

public interface RowMap<E> {
        public E RowMapping(ResultSet rs);
}
