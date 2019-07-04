package Graph;
import java.util.HashMap;

public class Vertex {
        public int v;
        public HashMap < Integer, Integer > edge = new HashMap < Integer, Integer > ();

        public Vertex(int v) {
            this.v = v;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Vertex))
                return false;

            Vertex vert = (Vertex) other;

            if (vert.v == this.v)
                return true;
            else
                return false;
        }

}

