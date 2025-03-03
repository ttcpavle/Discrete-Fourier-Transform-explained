package dft;

import java.io.PrintWriter;

public class VisualDFT{
  
	// show graph/histogram of complex number values (fft output or reconstructed signal in this case)
	// ploty library is used
    public static void exportToHTML(Complex[] data, float sampleRate, String filename, boolean spline) {
        try(PrintWriter pw = new PrintWriter(filename)) {
            pw.println("<!DOCTYPE html><html><head>");
            pw.println("<script src='https://cdn.plot.ly/plotly-latest.min.js'></script>");
            pw.println("</head><body><div id='plot'></div><script>");
            
            pw.println("var data = [");
            pw.println("{x: [");
            float binWidth = sampleRate/data.length;
            for(int i=0; i<data.length/2; i++) {
                if(i > 0) pw.print(",");
                pw.print(i * binWidth);
            }
            pw.println("], y: [");
            for(int i=0; i<data.length/2; i++) {
                if(i > 0) pw.print(",");
                pw.print(Complex.amplitude(data[i]));
            }
            pw.print("], ");
            //pw.println("], type: 'bar'}];");
            if(spline) {
            	pw.print("type: 'scatter', mode: 'lines', line: { color: 'blue', width: 2, shape: 'spline'}");            	
            }else {
            	pw.print("type: 'bar'");
            }
            pw.println("}];");
            pw.println("Plotly.newPlot('plot', data, {title: 'FFT Spectrum'});");
            pw.println("</script></body></html>");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}