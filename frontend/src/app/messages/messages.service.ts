import {inject, Injectable} from '@angular/core';
import {catchError, map, Observable, throwError} from 'rxjs';
import {MessageResponse} from './model/messages.model';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {API} from '../constants';

@Injectable({
  providedIn: 'root'
})
export class MessagesService {

  private http: HttpClient = inject(HttpClient);
  private MESSAGE_BASE_PATH: string = `${API.MESSAGES.BASE}`;

  public messages = (): Observable<MessageResponse[]> => {
    return this.http.get<MessageResponse[]>(`${this.MESSAGE_BASE_PATH}`)
      .pipe(
        map((response: MessageResponse[]) => response),
        catchError((error: HttpErrorResponse) => throwError(() => error?.error))
      );
  }

}
