package main;

import java.util.Arrays;

public class Valores implements ValoresITF {

	int[] array = new int[10];

	@Override
	public boolean ins(int v) {
		if (v < 1) {
			return false;
		} else {
			boolean resp = false;
			for (int i = 0; i < this.array.length; i++) {
				if (this.array[i] == 0) {
					this.array[i] = v;
					resp = true;
					break;
				}
			}
			return resp;
		}
	}

	@Override
	public int del(int i) {
		int greater = this.greater();
		if (greater == -1) {
			return -1;
		}
		if (i < this.array.length && i >= 0 && i < 10) {
			int resp = 0;
			resp = this.array[i];
			this.array[i] = 0;
			
			if (resp == 0) return -1; 
			return resp;
		} else {
			return -1;
		}
	}

	@Override
	public int size() {
		int resp = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] > 0) {
				resp++;
			}
		}
		return resp;
	}

	@Override
	public double mean() {
		double resp = 0;
		for (int i = 0; i < this.array.length; i++) {
			resp += this.array[i];
		}
		if (resp == 0) {
			return -1;
		}
		return resp / this.array.length;
	}

	@Override
	public int greater() {
		int resp = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] > resp) {
				resp = this.array[i];
			}
		}
		if (resp == 0) {
			return -1;
		}
		return resp;
	}

	@Override
	public int lower() {
		int resp = this.greater();
		if (resp == -1) {
			return resp;
		}
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] < resp && this.array[i] != 0) {
				resp = this.array[i];
			}
		}
		return resp;
	}
	
	public void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" = = = = = = ");
	}

}
