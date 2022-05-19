package dat.startcode.model.services;

public class SVG {
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate2 = "<svg height=\"%d%%\" " + "viewBox=\"%s\" "+ "preserveAspectRatio=\"xMinYMin\">";

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String markerPointer = "<defs>\n" +
            "            <marker\n" +
            "                    id=\"beginArrow\"\n" +
            "                    markerWidth=\"12\"\n" +
            "                    markerHeight=\"12\"\n" +
            "                    refX=\"0\"\n" +
            "                    refY=\"6\"\n" +
            "                    orient=\"auto\">\n" +
            "                <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>\n" +
            "            </marker>\n" +
            "            <marker\n" +
            "                    id=\"endArrow\"\n" +
            "                    markerWidth=\"12\"\n" +
            "                    markerHeight=\"12\"\n" +
            "                    refX=\"12\"\n" +
            "                    refY=\"6\"\n" +
            "                    orient=\"auto\">\n" +
            "                <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\"/>\n" +
            "            </marker>\n" +
            "        </defs>";

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%f\" y2=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String lineWithDashTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; fill: #ffffff\" stroke-dasharray=\"4\" />";

    private final String marker = "<line marker-start=url(#beginArrow) x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";


    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }

    public SVG(StringBuilder svg, String viewBox, int height) {
        this.svg = svg;
        this.viewBox = viewBox;
        this.height = height;
    }

    public void addRect(int x, int y, float height, float width) {

        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, float x2, int y2) {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }
    public void addLineWithDash(int x1, int y1, int x2, int y2){
        svg.append(String.format(lineWithDashTemplate,x1,y1,x2,y2));
    }
    public void addArrow(int x1, int y1, int x2, int y2){
        svg.append(String.format(marker, x1,y1,x2,y2));
    }

    public void addSvg(SVG innerSVG) {
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
