import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import './globals.css';
import ClientOnly from './components/ClientOnly';
import Navbar from './components/navbar/Navbar';
import RegisterModal from './components/modals/RegisterModal';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: '악기 라운지',
  description: '악기 거래 플랫폼',
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang='ko'>
      <body className={inter.className}>
        <ClientOnly>
          <Navbar />
          <RegisterModal />
        </ClientOnly>
        {children}
      </body>
    </html>
  );
}
