import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';

import {Score} from '../model/score';

@Injectable()
export class ScoreService {
  private scoresUrl: string;

  constructor(private http: HttpClient) {
    this.scoresUrl = 'http://localhost:8080/api/scores';
  }

  /** get scores */
  public getScores(category?: string): Observable<Score[]> {
    const params = (typeof category !== 'undefined') ? new HttpParams().append('category', category) : {};
    return this.http.get<Score[]>(this.scoresUrl + '/top', {params});
  }
}
