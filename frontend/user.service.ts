import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs';
import {User} from "./user.model";



@Injectable()
export class UserService {
  private url = 'http://localhost:9093/login';


  constructor(private httpClient: HttpClient) {
  }

  getLoginUsers(): Observable<User[]> {
    return this.httpClient
      .get<Array<User>>(this.url);
  }

}
