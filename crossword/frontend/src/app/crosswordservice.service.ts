import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CrosswordService {
  clueEndpoint = 'http://localhost:8080/crossword/entries/{{clue}}';
  constructor(private readonly httpClient: HttpClient) { }

  submitClue(clue: string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'withCredentials': 'true' });
    const options = { headers: headers };
    return this.httpClient.get(this.clueEndpoint.replace('{{clue}}', clue), options);
  }
}
