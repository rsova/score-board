import {HttpClient, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';

import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/api/users';
  }

  /* get names */
  public getNames(): Observable<string[]> {
    return this.http.get<string[]>(this.userUrl + '/names');
  }

  /* get user by name */
  getUser(name: string) {
    const params = new HttpParams().append('name', name);
    return this.http.get<User>(this.userUrl + '/getByName', {params});
  }
}
