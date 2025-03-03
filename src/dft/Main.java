package dft;

public class Main {
	
	// TEST:
    public static void main(String[] args) {
    	
        int sampleRate = 44100;
        float duration = 0.1f;
        int numSamples = (int)(sampleRate * duration);
        
        // 440 Hz + 1600 Hz waves
        Complex[] signal = new Complex[numSamples];
        for(int i=0; i<numSamples; i++) {
            float t = i / (float)sampleRate;
            float wave1 = (float)Math.sin(2 * Math.PI * 440 * t);
            float wave2 = (float)Math.sin(2 * Math.PI * 1600 * t);
            signal[i] = new Complex(wave1 + wave2*0.5f, 0);
        }
        
        // NOTE: only recursiveNFFT and directFT work correctly for any number of samples
        Complex[] fft = FFT.recursiveNFFT(signal);
        VisualDFT.exportToHTML(fft, sampleRate, "fft.html", false);

        Complex[] reconstructedSignal = FFT.inverseFT(fft);
        VisualDFT.exportToHTML(reconstructedSignal, sampleRate, "reconstructed.html", true);
        
        
    }
}
