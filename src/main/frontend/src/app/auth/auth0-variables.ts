import { environment } from '../../environments/environment';

interface AuthConfig {
  clientID: string;
  domain: string;
  callbackURL: string;
}

export const AUTH_CONFIG: AuthConfig = {
  clientID: '4xWiJnaIoWtecofOdVGKdrrDWEPIc3eo',
  domain: 'gamify9.auth0.com',
  callbackURL: environment.callbackURL
};
