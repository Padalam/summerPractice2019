package Graph;

public class Edge {
        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Edge))
                return false;

            Edge edge = (Edge) other;

            if (edge.v1 == this.v1 && edge.v2 == this.v2 && edge.weight == this.weight)
                return true;
            else
                return false;
        }


        public int v1;
        public int v2;
        public int weight;
}

