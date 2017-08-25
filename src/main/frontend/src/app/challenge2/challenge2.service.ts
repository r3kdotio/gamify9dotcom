import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class Challenge2Service {
    headers = new Headers({
        'Content-Type': 'application/json'
    });
    constructor(private http: Http) {
    }

    withEmptyModuleInfo(input: String) {
        return this.http.post('/api/challenge2/compilegameenginewithmoduleinfo/withemptymoduleinfo', input, { headers: this.headers })
            .map(res => res.json());
    }

    readInputWithModuleInfoDesktop(input: String) {
        return this.http.post('/api/challenge2/compilegameenginewithmoduleinfo/readinputwithmoduleinfodesktop', input, { headers: this.headers })
            .map(res => res.json());
    }
    readInputWithModuleInfoDesktopAndJPCT(input: String) {
        return this.http.post('/api/challenge2/compilegameenginewithmoduleinfo/readinputwithmoduleinfodesktopandjpct', input, { headers: this.headers })
            .map(res => res.json());
    }
    compileGameEngineWithoutModuleInfo(input: String) {
        return this.http.post('/api/challenge2/compilegameenginewithoutmoduleinfo', input, { headers: this.headers })
            .map(res => res.json());
    }
    compileWithoutModuleDir(input: String) {
        return this.http.post('/api/challenge2/compilemygame/compilewithoutmoduledir', input, { headers: this.headers })
            .map(res => res.json());
    }
    compileWithModuleDir(input: String) {
        return this.http.post('/api/challenge2/compilemygame/compilewithmoduledir', input, { headers: this.headers })
            .map(res => res.json());
    }

}
