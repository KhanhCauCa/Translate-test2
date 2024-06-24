import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  private apiUrl = 'http://localhost:8080/convert';

  constructor(private http: HttpClient) { }

  translateText(input: string, inputType: string, outputType: string): Observable<string> {
    const body = { input, inputType, outputType };

    return this.http.post<string>(this.apiUrl, body, { responseType: 'text' as 'json'})
  }
}
