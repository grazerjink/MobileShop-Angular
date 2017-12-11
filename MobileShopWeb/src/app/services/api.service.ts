import { Observable } from "rxjs/Observable";
import { of } from "rxjs/observable/of";
import { log } from "util";
import { HttpHeaders } from "@angular/common/http/src/headers";

export class ApiService {
    private url: string = "http://localhost";
    private port: number = 8181;
    private context: string = "MobileShopWS";

    getApiUrl(apiUrl: string) {
        return `${this.url}:${this.port}/${this.context}/${apiUrl}`;
    }

    handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {   
          // TODO: send the error to remote logging infrastructure
          console.error(error); // log to console instead   
          // TODO: better job of transforming error for user consumption
          log(`${operation} failed: ${error.message}`);   
          // Let the app keep running by returning an empty result.
          return of(result as T);
        }
    }
}