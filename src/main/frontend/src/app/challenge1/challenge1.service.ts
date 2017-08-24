import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class Challenge1Service {
    headers = new Headers({
        'Content-Type': 'application/json'
    });
    constructor(private http: Http) {
    }

    getScore() {
        return this.http.get('/api/scores/myscore', { headers: this.headers })
            .map(res => res.json());
    }

    submitJavaVersion(input: String) {
        return this.http.post('/api/challenge1/readjavaversion', input, { headers: this.headers })
            .map(res => res.json());
    }

    runGameAndScore(input: String) {
        return this.http.post('/api/challenge1/rungameandscore', input, { headers: this.headers })
            .map(res => res.json());
    }

    runGameAndScore2000Points(input: String) {
        return this.http.post('/api/challenge1/rungameandscore2000points', input, { headers: this.headers })
            .map(res => res.json());
    }
    createClassicMyGameJar(input: String) {
        return this.http.post('/api/challenge1/createclassicmygamejar', input, { headers: this.headers })
            .map(res => res.json());
    }
    createClassicGameEngineJar(input: String) {
        return this.http.post('/api/challenge1/createclassicgameenginejar', input, { headers: this.headers })
            .map(res => res.json());
    }

}
