import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  private apiUrl = "http://localhost:4200/translate"; // Cập nhật địa chỉ của Spring Boot API

  constructor(private http: HttpClient) { }

  translateText(input: string, sourceLang: string, targetLang: string): Observable<any> {
    const body = {
      input: input,
      sourceLang: sourceLang,
      targetLang: targetLang
    };
    return this.http.post(this.apiUrl, body);
  }
}
